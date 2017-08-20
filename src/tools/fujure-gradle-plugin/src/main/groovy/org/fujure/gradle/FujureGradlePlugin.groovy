package org.fujure.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaBasePlugin
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginConvention

class FujureGradlePlugin implements Plugin<Project> {
    void apply(Project project) {
        project.pluginManager.apply(JavaBasePlugin)

        configureSourceSetDefaults(project)

        project.pluginManager.apply(JavaPlugin)
    }

    private void configureSourceSetDefaults(Project project) {
        project.convention.getPlugin(JavaPluginConvention).sourceSets.all { sourceSet ->
            def compileFujureTaskName = sourceSet.getCompileTaskName('fujure')
            def compileFujureTask = project.tasks.create(compileFujureTaskName, CompileFujureTask)
            compileFujureTask.description = "Compiles ${sourceSet.name} Fujure source."

            def compileJavaTask = project.tasks.getByName(sourceSet.compileJavaTaskName)
            // execute the Fujure compile task before the Java compile task
            compileJavaTask.dependsOn(compileFujureTaskName)
            // add the Fujure task output directory to the Java input directories
            sourceSet.java.srcDir(compileFujureTask.outputDir)
        }
    }
}
