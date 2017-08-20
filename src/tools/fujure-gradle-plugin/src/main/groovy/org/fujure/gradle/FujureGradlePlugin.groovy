package org.fujure.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class FujureGradlePlugin implements Plugin<Project> {
    void apply(Project project) {
        project.tasks.create('fujure', CompileFujureTask)
    }
}
