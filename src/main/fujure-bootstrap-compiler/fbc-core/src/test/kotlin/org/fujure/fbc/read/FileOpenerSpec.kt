package org.fujure.fbc.read

import org.fujure.fbc.ProblematicFile
import org.fujure.test.utils.Assumption.Companion.assume
import org.funktionale.either.Disjunction
import org.specnaz.kotlin.junit.SpecnazKotlinJUnit

class FileOpenerSpec : SpecnazKotlinJUnit("FileOpener", {
    val fileOpener: FileOpener = SimpleFileOpener
    lateinit var result: Disjunction<ProblematicFile.BasicFileIssue, OpenedFile>

    fun open(filePath: String) {
        result = fileOpener.open(filePath)
    }

    fun assertOpeningFailed() =
            assume(result).isA<Disjunction.Left<ProblematicFile.BasicFileIssue, OpenedFile>>()

    it.describes("called with RandomFile_java") {
        it.beginsAll {
            open("RandomFile.java")
        }

        it.should("return Failure with InvalidFileExtension") {
            val failure = assertOpeningFailed()
            assume(failure.value).isA<ProblematicFile.BasicFileIssue.InvalidFileExtension>()
        }
    }

    it.describes("called with a Fujure file that doesn't exist") {
        it.beginsAll {
            open("DoesNotExist.fjr")
        }

        it.should("return Failure with FileNotFound") {
            val failure = assertOpeningFailed()
            assume(failure.value).isA<ProblematicFile.BasicFileIssue.FileNotFound>()
        }
    }

    it.describes("called with a Fujure file with a name that's not a valid Java class name") {
        it.beginsAll {
            open("Does Not Exist.fjr")
        }

        it.should("return Failure with InvalidFileName") {
            val failure = assertOpeningFailed()
            assume(failure.value).isA<ProblematicFile.BasicFileIssue.InvalidFileName>()
        }
    }

    it.describes("called with a Fujure file that doesn't exist") {
        it.beginsAll {
            open("DoesNotExist.fjr")
        }

        it.should("return Failure with FileNotFound") {
            val failure = assertOpeningFailed()
            assume(failure.value).isA<ProblematicFile.BasicFileIssue.FileNotFound>()
        }
    }

    it.describes("called with a Fujure file with a name that contains a $") {
        it.beginsAll {
            open("\$File.fjr")
        }

        it.should("return Failure with InvalidFileName") {
            val failure = assertOpeningFailed()
            assume(failure.value).isA<ProblematicFile.BasicFileIssue.InvalidFileName>()
        }
    }

    it.describes("called with a Fujure file with the name '_'") {
        it.beginsAll {
            open("_.fjr")
        }

        it.should("return Failure with InvalidFileName") {
            val failure = assertOpeningFailed()
            assume(failure.value).isA<ProblematicFile.BasicFileIssue.InvalidFileName>()
        }
    }

    it.describes("called with a Fujure file with a name that's a Java-only keyword") {
        it.beginsAll {
            open("class.fjr")
        }

        it.should("return Failure with InvalidFileName") {
            val failure = assertOpeningFailed()
            assume(failure.value).isA<ProblematicFile.BasicFileIssue.InvalidFileName>()
        }
    }

    it.describes("called with a Fujure file with a name that's both a Java and Fujure keyword") {
        it.beginsAll {
            open("package.fjr")
        }

        it.should("return Failure with InvalidFileName") {
            val failure = assertOpeningFailed()
            assume(failure.value).isA<ProblematicFile.BasicFileIssue.InvalidFileName>()
        }
    }

    it.describes("called with a Fujure file with a name that's a Fujure-only keyword") {
        it.beginsAll {
            open("def.fjr")
        }

        it.should("return Failure with InvalidFileName") {
            val failure = assertOpeningFailed()
            assume(failure.value).isA<ProblematicFile.BasicFileIssue.InvalidFileName>()
        }
    }
})
