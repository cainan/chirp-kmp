package com.cso.chat.data.notification

import com.cso.chat.domain.notification.PushNotificationService
import kotlinx.coroutines.flow.Flow

expect class FirebasePushNotificationService : PushNotificationService {

    override fun observeDeviceToken(): Flow<String?>

}