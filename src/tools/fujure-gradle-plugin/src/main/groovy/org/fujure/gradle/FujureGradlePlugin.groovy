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
            def taskName = sourceSet.getCompileTaskName('fujure')
            def task = project.tasks.create(taskName, CompileFujureTask)
            task.description = "Compiles ${sourceSet.name} Fujure source."
        }
    }
}
