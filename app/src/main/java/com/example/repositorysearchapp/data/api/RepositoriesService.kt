@file:UseSerializers(URLSerializer::class)

package com.example.repositorysearchapp.data.api

import com.example.repositorysearchapp.data.api.serializer.URLSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import retrofit2.http.GET

interface RepositoriesService {
    @GET("search/repositories")
    suspend fun getRepositories(

    ): RepositoriesResponse
}

@Serializable
class RepositoriesResponse(
    @SerialName("total_count") val totalCount: Int,
    @SerialName("incomplete_results") val incompleteResults: Boolean,
    val items: LabelSearchResultItem
)

@Serializable
class LabelSearchResultItem(
    val id: Int,
    @SerialName("node_id") val nodeId: String,
    val url: String,
    val name: String,
    @SerialName("full_name") val fullName: String,
    val owner: List<NullableSimpleUser>,
    val private: Boolean,
    @SerialName("html_url") val htmlUrl: String,
    val fork: Boolean,
    @SerialName("created_at") val createdAt: String,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("pushed_at") val pushedAt: String,
    val homepage: String,
    val size: Int,
    @SerialName("stargazers_count") val stargazersCount: Int,
    @SerialName("watchers_count") val watchersCount: Int,
    val language: String,
    @SerialName("forks_count") val forksCount: Int,
    @SerialName("open_issues_count") val openIssuesCount: Int,
    @SerialName("master_branch") val masterBranch: String,
    @SerialName("default_branch") val defaultBranch: String,
    val score: Float,
    @SerialName("forks_url") val forksUrl: String,
    @SerialName("keys_url") val keysUrl: String,
    @SerialName("collaborators_url") val collaboratorsUrl: String,
    @SerialName("teams_url") val teamsUrl: String,
    @SerialName("hooks_url") val hooksUrl: String,
    @SerialName("issue_events_url") val issueEventsUrl: String,
    @SerialName("events_url") val eventsUrl: String,
    @SerialName("assignees_url") val assigneesUrl: String,
    @SerialName("branches_url") val branchesUrl: String,
    @SerialName("tags_url") val tagsUrl: String,
    @SerialName("statuses_url") val statusesUrl: String,
    @SerialName("languages_url") val languagesUrl: String,
    @SerialName("stargazers_url") val stargazersUrl: String,
    @SerialName("contributors_url") val contributorsUrl: String,
    @SerialName("subscribers_url") val subscribersUrl: String,
    @SerialName("subscription_url") val subscriptionUrl: String,
    @SerialName("commits_url") val commitsUrl: String,
    @SerialName("git_commits_url") val gitCommitsUrl: String,
    @SerialName("comments_url") val commentsUrl: String,
    @SerialName("issue_comment_url") val issueCommentUrl: String,
    @SerialName("contents_url") val contentsUrl: String,
    @SerialName("compare_url") val compareUrl: String,
    @SerialName("merges_url") val merges_url: String,
    @SerialName("archive_url") val archiveUrl: String,
    @SerialName("downloads_url") val downloadsUrl: String,
    @SerialName("issues_url") val issuesUrl: String,
    @SerialName("pulls_url") val pullsUrl: String,
    @SerialName("milestones_url") val milestonesUrl: String,
    @SerialName("notifications_url") val notificationsUrl: String,
    @SerialName("labels_url") val labelsUrl: String,
    @SerialName("releases_url") val releases: String,
    @SerialName("deployments_url") val developmentsUrl: String,
    @SerialName("git_url") val gitUrl: String,
    @SerialName("ssh_url") val sshUrl: String,
    @SerialName("clone_url") val cloneUrl: String,
    @SerialName("svn_url") val svnUrl: String,
    val forks: Int,
    @SerialName("open_issues") val openIssue: Int,
    val watchers: Int,
    val topics: List<Int>,
    @SerialName("mirror_url") val mirrorUrl: String?,
    @SerialName("has_issues") val hasIssues: Boolean,
    @SerialName("has_projects") val hasProjects: Boolean,
    @SerialName("has_pages") val hasPages: Boolean,
    @SerialName("has_wiki") val hasWiki: Boolean,
    @SerialName("has_downloads") val hasDownloads: Boolean,
    val archived: Boolean,
    val disabled: Boolean,
    val description: String?=null
)

@Serializable
class NullableSimpleUser(
    val id: Int,
    @SerialName("node_id") val nodeId: String,
    val name: String?,
    val email: String?,
    val login: String,
    @SerialName("avatar_url") val avatarUrl: String,
    @SerialName("gravatar_id") val gravatarId: String?,
    val url: String,
    @SerialName("html_url") val htmlUrl: String,
    @SerialName("followers_url") val followersUrl: String,
    @SerialName("following_url") val followingUrl: String,
    @SerialName("gists_url") val gistsUrl: String,
    @SerialName("starred_url") val starredUrl: String,
    @SerialName("subscriptions_url") val subscriptionsUrl: String,
    @SerialName("organizations_url") val organizationsUrl: String,
    @SerialName("repos_url") val reposUrl: String,
    @SerialName("events_url") val eventsUrl: String,
    @SerialName("received_events_url") val receivedEventsUrl: String,
    val type: String,
    @SerialName("site_admin") val siteAdmin: Boolean,
    @SerialName("starred_at") val starredAt: String
)