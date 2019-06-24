package hackweek.group.filterbot

import com.google.auth.oauth2.GoogleCredentials
import com.google.auth.oauth2.ServiceAccountCredentials
import net.dv8tion.jda.core.JDA
import net.dv8tion.jda.core.JDABuilder

private val GCP_PROJECT_ID: String = System.getenv("GCP_PROJECT_ID")
private val DISCORD_TOKEN: String = System.getenv("DISCORD_TOKEN")
private val GOOGLE_CREDENTIALS: GoogleCredentials =
    ServiceAccountCredentials.fromStream(System.getenv("GOOGLE_APPLICATION_CREDENTIALS").byteInputStream())


fun main() {
    val jdaBot: JDA = JDABuilder(DISCORD_TOKEN).build()

    jdaBot.addEventListener(
        MessageListener(gcpAuth = GOOGLE_CREDENTIALS, gcpProjectID = GCP_PROJECT_ID)
    )
}