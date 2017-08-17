package org.fujure.gradle

import org.fujure.fbc.Main
import org.gradle.api.Project
import org.gradle.api.Plugin

class FujureGradlePlugin implements Plugin<Project> {
    void apply(Project project) {
//        project.extensions.create('greeting', GreetingPluginExtension)

        project.task('fujure') {
            doLast {
                println "Calling Fujure compiler"
                Main.mainReturningExitCode([] as String[])
            }
        }
    }
}
