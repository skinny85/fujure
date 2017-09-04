package org.fujure.fbc.cli

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.Main
import org.specnaz.kotlin.junit.SpecnazKotlinJUnit
import java.io.File

class MainSpec : SpecnazKotlinJUnit("Main#runCompiler", {
    val outputDirectory = File("build/tmp/fujure2java")
    val output = File(outputDirectory, "Empty.java")

    it.beginsAll {
        outputDirectory.mkdirs()
    }

    it.beginsAll {
        output.delete()
    }

    var result = -300

    it.beginsAll {
        result = Main.runCompiler(arrayOf(
                "-o", outputDirectory.path,
                "src/test/resources/examples/fujure/Empty.fjr"))
    }

    it.should("return 0") {
        assertThat(result).isZero()
    }

    it.should("generate an Empty.java file") {
        assertThat(output).exists()
    }
})
