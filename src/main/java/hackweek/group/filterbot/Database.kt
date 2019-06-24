package hackweek.group.filterbot

import com.google.api.core.ApiFuture
import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.DocumentReference
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.FirestoreOptions
import com.google.cloud.firestore.WriteResult

/**
 * Firestore based Database
 *
 * @constructor Creates a Firestore Database given credentials and a projectID
 * */
class Database(gcpAuth: GoogleCredentials, gcpProjectId: String) {
    // Firestore Database
    private val db: Firestore = FirestoreOptions.getDefaultInstance()
        .toBuilder()
        .setProjectId(gcpProjectId)
        .setCredentials(gcpAuth)
        .build()
        .service

    /**
     * @return command prefix given a guildID
     *  @param guildID GuildID of a server
     * */
    fun getCommandPrefix(guildID: String): String {
        val docRef: DocumentReference = db.collection("guilds").document(guildID)
        val data: MutableMap<String, Any> = docRef.get().get().data!!
        return data["commandPrefix"] as String
    }

    /**
     * Adds or Sets a prefix to the database.
     * @param guildID GuildID of a server
     * @param prefix Command Prefix
     */
    fun setCommandPrefix(guildID: String, prefix: String) {
        val docRef: DocumentReference = db.collection("guilds").document(guildID)
        val data: MutableMap<String, Any> = docRef.get().get().data!!
        data["commandPrefix"] = prefix
        val result: ApiFuture<WriteResult> = docRef.set(data)
        result.get()
    }
}