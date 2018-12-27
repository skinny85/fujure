package org.fujure.fbc.codegen

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.TypeSpec
import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.SymbolTable
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.Module
import org.fujure.fbc.ast.ValueReference
import org.fujure.fbc.parse.ParsedFile
import java.lang.reflect.Type
import javax.lang.model.element.Modifier

object FileContentsCodeGen {
    fun generate(parsedFile: ParsedFile, symbolTable: SymbolTable): JavaFile {
        val inputFile = parsedFile.inputFile
        val className = inputFile.moduleName

        val typeSpecBuilder = TypeSpec.classBuilder(className)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)

        val fileContents = parsedFile.ast
        for (def in fileContents.defs) {
            when (def) {
                is Def.ValueDef.SimpleValueDef ->
                    typeSpecBuilder.addField(generateField(def, parsedFile.module(), symbolTable))
            }
        }

        return JavaFile
                .builder(fileContents.packageName, typeSpecBuilder.build())
                .skipJavaLangImports(true)
                .build()
    }

    private fun generateField(simpleValueDef: Def.ValueDef.SimpleValueDef, module: Module,
            symbolTable: SymbolTable): FieldSpec {
        val lookupResult = symbolTable.lookup(module, ValueReference(simpleValueDef.id))
        val variableType = toJavaType(lookupResult.qualifiedType)!!

        var format = "\$L"
        val initializer: Any
        when (simpleValueDef.initializer) {
            is Expr.IntLiteral -> {
                initializer = simpleValueDef.initializer.value
            }
            is Expr.UnitLiteral -> {
                initializer = "null"
            }
            is Expr.BoolLiteral -> {
                initializer = simpleValueDef.initializer == Expr.BoolLiteral.True
            }
            is Expr.CharLiteral -> {
                initializer = simpleValueDef.initializer.value
            }
            is Expr.StringLiteral -> {
                initializer = """"${simpleValueDef.initializer.value}""""
            }
            is Expr.ValueReferenceExpr -> {
                if (simpleValueDef.initializer.ref.ids.size == 1) {
                    initializer = simpleValueDef.initializer.ref.inStringForm()
                } else {
                    val reference = symbolTable.lookup(module, simpleValueDef.initializer.ref)
                    initializer = ClassName.get(reference.module.packageName, reference.module.moduleName)
                    format = "\$T.${simpleValueDef.initializer.ref.variable()}"
                }
            }
        }
        return FieldSpec.builder(variableType, simpleValueDef.id,
                Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .initializer(format, initializer)
                .build()
    }

    private fun toJavaType(qualifiedType: QualifiedType?): Type? {
        return when (qualifiedType) {
            BuiltInTypes.Int -> Integer.TYPE
            BuiltInTypes.Unit -> Void::class.java
            BuiltInTypes.Bool -> java.lang.Boolean.TYPE
            BuiltInTypes.Char -> Character.TYPE
            BuiltInTypes.String -> java.lang.String::class.java
            else -> null
        }
    }
}
