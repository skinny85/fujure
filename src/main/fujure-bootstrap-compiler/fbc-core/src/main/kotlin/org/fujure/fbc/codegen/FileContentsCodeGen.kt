package org.fujure.fbc.codegen

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.TypeSpec
import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.ast.AstRoot
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.SymbolTable
import org.fujure.fbc.ast.ValueReference
import java.lang.reflect.Type
import javax.lang.model.element.Modifier

object FileContentsCodeGen {
    fun generate(astRoot: AstRoot, symbolTable: SymbolTable): JavaFile {
        val inputFile = astRoot.inputFile
        val className = inputFile.moduleName

        val typeSpecBuilder = TypeSpec.classBuilder(className)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)

        symbolTable.enterContext(inputFile)

        val fileContents = astRoot.fileContents
        for (def in fileContents.defs) {
            when (def) {
                is Def.ValueDef.SimpleValueDef ->
                    typeSpecBuilder.addField(generateField(def, symbolTable))
            }
        }

        return JavaFile
                .builder(fileContents.packageName, typeSpecBuilder.build())
                .skipJavaLangImports(true)
                .build()
    }

    private fun generateField(simpleValueDef: Def.ValueDef.SimpleValueDef, symbolTable: SymbolTable): FieldSpec {
        val lookupResult = symbolTable.lookup(ValueReference(simpleValueDef.id))
        val variableType = toJavaType((lookupResult as SymbolTable.LookupResult.RefFound).qualifiedType)!!

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
                val lookupResult = symbolTable.lookup(simpleValueDef.initializer.ref, simpleValueDef.id) as
                        SymbolTable.LookupResult.RefFound
                initializer = ClassName.get(lookupResult.module.packageName, lookupResult.module.moduleName)
                format = "\$T.${simpleValueDef.initializer.ref.variable()}"
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
