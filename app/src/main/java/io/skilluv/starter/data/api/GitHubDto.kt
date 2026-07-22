package io.skilluv.starter.data.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RepoDto(
    @SerialName("stargazers_count") val stargazersCount: Int,
)
