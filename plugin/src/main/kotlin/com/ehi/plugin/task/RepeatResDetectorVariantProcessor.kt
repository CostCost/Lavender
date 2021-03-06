package com.ehi.plugin.task

import com.android.build.gradle.api.BaseVariant
import com.android.build.gradle.internal.api.ApplicationVariantImpl
import com.ehi.plugin.spi.VariantProcessor
import com.google.auto.service.AutoService

/**
 * Author: Omooo
 * Date: 2019/9/27
 * Version: v0.1.0
 * Desc: 注册 RepeatResDetectorTask
 * @see RepeatResDetectorTask
 */
@AutoService(VariantProcessor::class)
class RepeatResDetectorVariantProcessor : VariantProcessor {
    override fun process(variant: BaseVariant) {
        val variantData = (variant as ApplicationVariantImpl).variantData
        val tasks = variantData.scope.globalScope.project.tasks
        tasks.findByName("repeatRes") ?: tasks.create(
            "repeatRes",
            RepeatResDetectorTask::class.java
        )
    }
}