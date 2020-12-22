package com.github.mikesafonov.jenkins.linter

import com.intellij.openapi.vfs.VirtualFile

/**
 * @author Mike Safonov
 */

class LinterResponse(code: Int, val message: String) : JenkinsResponse(code)

data class JenkinsCrumb(val crumb: String, val crumbRequestField: String)

open class JenkinsResponse(val code: Int) {
    val success: Boolean
        get() = code == HttpCodes.SUCCESS
}

data class ScriptError(val line: Int, val column: Int, val message: String)

data class ScriptErrorData(val file: VirtualFile, val error: ScriptError)
