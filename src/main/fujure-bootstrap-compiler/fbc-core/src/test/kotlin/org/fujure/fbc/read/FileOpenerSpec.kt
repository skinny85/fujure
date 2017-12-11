package org.fujure.fbc.read

import org.fujure.fbc.ProblematicFile
import org.fujure.test.utils.Assumption.Companion.assume
import org.specnaz.kotlin.junit.SpecnazKotlinJUnit

class FileOpenerSpec : SpecnazKotlinJUnit("FileOpener", {
    val fileOpener: FileOpener = SimpleFileOpener
    lateinit var result: FileOpenResult

    it.describes("called with RandomFile_java") {
        it.beginsAll {
            result = fileOpener.open("RandomFile.java")
        }

        it.should("return Failure with InvalidFileExtension") {
            val failure = assume(result).isA<FileOpenResult.Failure>()
            assume(failure.cause).isA<ProblematicFile.BasicFileIssue.InvalidFileExtension>()
        }
    }

    it.describes("called with a Fujure file that doesn't exist") {
        it.beginsAll {
            result = fileOpener.open("DoesNotExist.fjr")
        }

        it.should("return Failure with FileNotFound") {
            val failure = assume(result).isA<FileOpenResult.Failure>()
            assume(failure.cause).isA<ProblematicFile.BasicFileIssue.FileNotFound>()
        }
    }

    it.describes("called with a Fujure file with a name that's not a valid Java class name") {
        it.beginsAll {
            result = fileOpener.open("Does Not Exist.fjr")
        }

        it.should("return Failure with InvalidFileName") {
            val failure = assume(result).isA<FileOpenResult.Failure>()
            assume(failure.cause).isA<ProblematicFile.BasicFileIssue.InvalidFileName>()
        }
    }

    it.describes("called with a Fujure file that doesn't exist") {
        it.beginsAll {
            result = fileOpener.open("DoesNotExist.fjr")
        }

        it.should("return Failure with FileNotFound") {
            val failure = assume(result).isA<FileOpenResult.Failure>()
            assume(failure.cause).isA<ProblematicFile.BasicFileIssue.FileNotFound>()
        }
    }

    it.describes("called with a Fujure file with a name that contains a $") {
        it.beginsAll {
            result = fileOpener.open("\$File.fjr")
        }

        it.should("return Failure with InvalidFileName") {
            val failure = assume(result).isA<FileOpenResult.Failure>()
            assume(failure.cause).isA<ProblematicFile.BasicFileIssue.InvalidFileName>()
        }
    }

    it.describes("called with a Fujure file with the name '_'") {
        it.beginsAll {
            result = fileOpener.open("_.fjr")
        }

        it.should("return Failure with InvalidFileName") {
            val failure = assume(result).isA<FileOpenResult.Failure>()
            assume(failure.cause).isA<ProblematicFile.BasicFileIssue.InvalidFileName>()
        }
    }

    it.describes("called with a Fujure file with a name that's a Java-only keyword") {
        it.beginsAll {
            result = fileOpener.open("class.fjr")
        }

        it.should("return Failure with InvalidFileName") {
            val failure = assume(result).isA<FileOpenResult.Failure>()
            assume(failure.cause).isA<ProblematicFile.BasicFileIssue.InvalidFileName>()
        }
    }

    it.describes("called with a Fujure file with a name that's both a Java and Fujure keyword") {
        it.beginsAll {
            result = fileOpener.open("package.fjr")
        }

        it.should("return Failure with InvalidFileName") {
            val failure = assume(result).isA<FileOpenResult.Failure>()
            assume(failure.cause).isA<ProblematicFile.BasicFileIssue.InvalidFileName>()
        }
    }

    it.describes("called with a Fujure file with a name that's a Fujure-only keyword") {
        it.beginsAll {
            result = fileOpener.open("def.fjr")
        }

        it.should("return Failure with InvalidFileName") {
            val failure = assume(result).isA<FileOpenResult.Failure>()
            assume(failure.cause).isA<ProblematicFile.BasicFileIssue.InvalidFileName>()
        }
    }
})
