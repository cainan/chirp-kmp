package com.cso.core.presentation.permissions

expect class PermissionController {
    suspend fun requestPermission(permission: Permission): PermissionState
}