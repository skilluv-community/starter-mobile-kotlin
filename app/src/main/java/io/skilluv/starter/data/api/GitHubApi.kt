package io.skilluv.starter.data.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class GitHubApi @Inject constructor(private val client: HttpClient) {
    suspend fun repo(fullName: String): RepoDto =
        client.get("https://api.github.com/repos/$fullName").body()
}
