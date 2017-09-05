package org.fujure.fbc.read

import org.fujure.fbc.ProblematicFile
import org.fujure.test.utils.Assumption.Companion.assume
import org.specnaz.kotlin.junit.SpecnazKotlinJUnit
import org.specnaz.kotlin.utils.Deferred

class FileOpenerSpec : SpecnazKotlinJUnit("FileOpener", {
    val fileOpener: FileOpener = SimpleFileOpener

    it.describes("called with RandomFile_java") {
        val result = Deferred<FileOpenResult>()

        it.beginsAll {
            result.v = fileOpener.open("RandomFile.java")
        }

        it.should("return Failure with InvalidFileExtension") {
            val failure = assume(result.v).isA<FileOpenResult.Failure>()
            assume(failure.cause).isA<ProblematicFile.BasicFileIssue.InvalidFileExtension>()
        }
    }

    it.describes("called with a Fujure file that doesn't exist") {
        val result = Deferred<FileOpenResult>()

        it.beginsAll {
            result.v = fileOpener.open("DoesNotExist.fjr")
        }

        it.should("return Failure with FileNotFound") {
            val failure = assume(result.v).isA<FileOpenResult.Failure>()
            assume(failure.cause).isA<ProblematicFile.BasicFileIssue.FileNotFound>()
        }
    }
})
