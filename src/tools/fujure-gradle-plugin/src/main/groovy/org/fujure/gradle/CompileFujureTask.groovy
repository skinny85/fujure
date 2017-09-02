package org.fujure.gradle

import org.fujure.fbc.Main
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class CompileFujureTask extends DefaultTask {
    final String outputDir = "generated-src"

    @TaskAction
    protected void compile() {
        println "Calling Fujure compiler (from a task)"
        def fileTree = project.fileTree(dir: 'src/main/fujure', include: '**/*.fjr')
        def files = fileTree.files
        String[] args = new String[files.size() + 2]
        args[0] = "-o"
        args[1] = outputDir
        int i = 2
        for (File file : files) {
            args[i++] = file.path
        }
        def exitCode = Main.runCompiler(args)
        if (exitCode != 0)
            throw new RuntimeException("Compilation failed (exit code: $exitCode)")
    }
}
