package com.shuyu.github.kotlin.service

import com.shuyu.github.kotlin.model.bean.CommitsComparison
import com.shuyu.github.kotlin.model.bean.RepoCommit
import com.shuyu.github.kotlin.model.bean.RepoCommitExt

import java.util.ArrayList

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query


interface CommitService {

    @GET("repos/{owner}/{repo}/commits")
    fun getRepoCommits(
            @Header("forceNetWork") forceNetWork: Boolean,
            @Path("owner") owner: String,
            @Path("repo") repo: String,
            //SHA or branch to start listing commits from. Default: the repository’s default branch (usually master).
            @Query("sha") branch: String,
            @Query("page") page: Int
    ): Observable<Response<ArrayList<RepoCommit>>>

    @GET("repos/{owner}/{repo}/commits/{sha}")
    fun getCommitInfo(
            @Header("forceNetWork") forceNetWork: Boolean,
            @Path("owner") owner: String,
            @Path("repo") repo: String,
            @Path("sha") sha: String
    ): Observable<Response<RepoCommitExt>>

    @GET("repos/{owner}/{repo}/commits/{ref}/comments")
    fun getCommitComments(
            @Header("forceNetWork") forceNetWork: Boolean,
            @Path("owner") owner: String,
            @Path("repo") repo: String,
            @Path("ref") ref: String,
            @Query("page") page: Int
    ): Observable<Response<ArrayList<RepoCommit>>>

    @GET("repos/{owner}/{repo}/compare/{before}...{head}")
    fun compareTwoCommits(
            @Header("forceNetWork") forceNetWork: Boolean,
            @Path("owner") owner: String,
            @Path("repo") repo: String,
            @Path("before") before: String,
            @Path("head") head: String
    ): Observable<Response<CommitsComparison>>

}
