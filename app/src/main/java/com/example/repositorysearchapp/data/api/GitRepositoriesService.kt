@file:UseSerializers(URLSerializer::class)

package com.example.repositorysearchapp.data.api

import com.example.repositorysearchapp.data.api.serializer.URLSerializer
import com.example.repositorysearchapp.model.GitRepositories
import com.example.repositorysearchapp.model.LabelSearchResultItem
import com.example.repositorysearchapp.model.NullableSimpleUser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GitRepositoriesService {
    @GET("search/repositories")
    suspend fun getRepositories(
        @Header("accept") accept: String = HEADER,
        @Query("q") q: String,
        @Query("sort") sort: String?,
        @Query("order") order: String?,
        @Query("per_page") perPage: Int?,
        @Query("page") page: Int?
    ): GitRepositoriesResponse

    companion object {
        private const val HEADER = "application/vnd.github.v3+json"
    }
}

@Serializable
class GitRepositoriesResponse(
    @SerialName("total_count") val totalCount: Int,
    @SerialName("incomplete_results") val incompleteResults: Boolean,
    val items: List<LabelSearchResultItemResponse>
)

@Serializable
class LabelSearchResultItemResponse(
    val id: Int,
    @SerialName("node_id") val nodeId: String,
    val url: String,
    val name: String,
    @SerialName("full_name") val fullName: String,
    val owner: NullableSimpleUserResponse,
    val private: Boolean,
    @SerialName("html_url") val htmlUrl: String,
    val fork: Boolean,
    @SerialName("created_at") val createdAt: String,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("pushed_at") val pushedAt: String,
    val homepage: String? = null,
    val size: Int,
    @SerialName("stargazers_count") val stargazersCount: Int,
    @SerialName("watchers_count") val watchersCount: Int,
    val language: String? = null,
    @SerialName("forks_count") val forksCount: Int,
    @SerialName("open_issues_count") val openIssuesCount: Int,
    @SerialName("master_branch") val masterBranch: String? = null,
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
    val topics: List<String>,
    @SerialName("mirror_url") val mirrorUrl: String? = null,
    @SerialName("has_issues") val hasIssues: Boolean,
    @SerialName("has_projects") val hasProjects: Boolean,
    @SerialName("has_pages") val hasPages: Boolean,
    @SerialName("has_wiki") val hasWiki: Boolean,
    @SerialName("has_downloads") val hasDownloads: Boolean,
    val archived: Boolean,
    val disabled: Boolean,
    val description: String? = null
)

@Serializable
class NullableSimpleUserResponse(
    val id: Int,
    @SerialName("node_id") val nodeId: String,
    val name: String? = null,
    val email: String? = null,
    val login: String,
    @SerialName("avatar_url") val avatarUrl: String,
    @SerialName("gravatar_id") val gravatarId: String? = null,
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
    @SerialName("starred_at") val starredAt: String? = null
)

fun GitRepositoriesResponse.toModel(): GitRepositories {
    return GitRepositories(
        totalCount = this.totalCount,
        incompleteResults = this.incompleteResults,
        items = this.items.toModel()
    )
}

fun List<LabelSearchResultItemResponse>.toModel(): List<LabelSearchResultItem> = this.map(LabelSearchResultItemResponse::toModel)

fun LabelSearchResultItemResponse.toModel(): LabelSearchResultItem {
    return LabelSearchResultItem(
        id = this.id,
        nodeId = this.nodeId,
        url = this.url,
        name = this.name,
        fullName = this.fullName,
        owner = this.owner.toModel(),
        private = this.private,
        htmlUrl = this.htmlUrl,
        fork = this.fork,
        createdAt = createdAt,
        updatedAt = updatedAt,
        pushedAt = this.pushedAt,
        homepage = this.homepage,
        size = this.size,
        stargazersCount = this.stargazersCount,
        watchersCount = this.watchersCount,
        language = this.language,
        forksCount = this.forksCount,
        openIssuesCount = this.openIssuesCount,
        masterBranch = this.masterBranch,
        defaultBranch = this.defaultBranch,
        score = this.score,
        forksUrl = this.forksUrl,
        keysUrl = this.keysUrl,
        collaboratorsUrl = this.collaboratorsUrl,
        teamsUrl = this.teamsUrl,
        hooksUrl = this.hooksUrl,
        issueEventsUrl = this.issueEventsUrl,
        eventsUrl = this.eventsUrl,
        assigneesUrl = this.assigneesUrl,
        branchesUrl = this.branchesUrl,
        tagsUrl = this.tagsUrl,
        statusesUrl = this.statusesUrl,
        languagesUrl = this.languagesUrl,
        stargazersUrl = this.stargazersUrl,
        contributorsUrl = this.contributorsUrl,
        subscribersUrl = this.subscribersUrl,
        subscriptionUrl = this.subscriptionUrl,
        commitsUrl = this.commitsUrl,
        gitCommitsUrl = this.gitCommitsUrl,
        commentsUrl = this.commentsUrl,
        issueCommentUrl = this.issueCommentUrl,
        contentsUrl = this.contentsUrl,
        compareUrl = this.compareUrl,
        merges_url = this.merges_url,
        archiveUrl = this.archiveUrl,
        downloadsUrl = this.downloadsUrl,
        issuesUrl = this.issuesUrl,
        pullsUrl = this.pullsUrl,
        milestonesUrl = this.milestonesUrl,
        notificationsUrl = this.notificationsUrl,
        labelsUrl = this.labelsUrl,
        releases = this.releases,
        developmentsUrl = this.developmentsUrl,
        gitUrl = this.gitUrl,
        sshUrl = this.sshUrl,
        cloneUrl = this.cloneUrl,
        svnUrl = this.svnUrl,
        forks = this.forks,
        openIssue = this.openIssue,
        watchers = this.watchers,
        topics = this.topics,
        mirrorUrl = this.mirrorUrl,
        hasIssues = this.hasIssues,
        hasProjects = this.hasProjects,
        hasPages = this.hasPages,
        hasWiki = this.hasWiki,
        hasDownloads = this.hasDownloads,
        archived = this.archived,
        disabled = this.disabled,
        description = this.description
    )
}

fun NullableSimpleUserResponse.toModel(): NullableSimpleUser {
    return NullableSimpleUser(
        id = this.id,
        nodeId = this.nodeId,
        name = this.name,
        email = this.email,
        login = this.login,
        avatarUrl = this.avatarUrl,
        gravatarId = this.gravatarId,
        url = this.url,
        htmlUrl = this.htmlUrl,
        followersUrl = this.followersUrl,
        followingUrl = this.followingUrl,
        gistsUrl = this.gistsUrl,
        starredUrl = this.starredUrl,
        subscriptionsUrl = this.subscriptionsUrl,
        organizationsUrl = this.organizationsUrl,
        reposUrl = this.reposUrl,
        eventsUrl = this.eventsUrl,
        receivedEventsUrl = this.receivedEventsUrl,
        type = this.type,
        siteAdmin = this.siteAdmin,
        starredAt = this.starredAt
    )
}