/**
 *  Owner
 *  com.alaric.norris.study.rxjava.retrofitstudy
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2016/4/25         AlaricNorris
 *  Copyright (c) 2016, TNT All Rights Reserved.
 */
package com.alaric.norris.study.retrofitstudy;

/**
 @formatter:off ClassName:      Owner
 @formatter:off Function:       ${TODO}  ADD FUNCTION
 @formatter:off Contact:        Norris.sly@gmail.com
 @formatter:off @author         AlaricNorris
 @formatter:off @version        Ver 1.0
 @formatter:off @since          I used to be a programmer like you, then I took an arrow in the knee
 @formatter:off ***************************************************************************************************
 @formatter:off Modified By     AlaricNorris     2016/4/25    14:21
 @formatter:off Modifications:  ${TODO}
 @formatter:off ***************************************************************************************************
 */
public class Owner {
    private String login;

    private int id;

    private String avatar_url;

    private String gravatar_id;

    private String url;

    private String html_url;

    private String followers_url;

    private String following_url;

    private String gists_url;

    private String starred_url;

    private String subscriptions_url;

    private String organizations_url;

    private String repos_url;

    private String events_url;

    private String received_events_url;

    private String type;

    private boolean site_admin;
    public String getLogin () {
        return this.login;
    }
    public void setLogin ( String login ) {
        this.login = login;
    }
    public int getId () {
        return this.id;
    }
    public void setId ( int id ) {
        this.id = id;
    }
    public String getAvatar_url () {
        return this.avatar_url;
    }
    public void setAvatar_url ( String avatar_url ) {
        this.avatar_url = avatar_url;
    }
    public String getGravatar_id () {
        return this.gravatar_id;
    }
    public void setGravatar_id ( String gravatar_id ) {
        this.gravatar_id = gravatar_id;
    }
    public String getUrl () {
        return this.url;
    }
    public void setUrl ( String url ) {
        this.url = url;
    }
    public String getHtml_url () {
        return this.html_url;
    }
    public void setHtml_url ( String html_url ) {
        this.html_url = html_url;
    }
    public String getFollowers_url () {
        return this.followers_url;
    }
    public void setFollowers_url ( String followers_url ) {
        this.followers_url = followers_url;
    }
    public String getFollowing_url () {
        return this.following_url;
    }
    public void setFollowing_url ( String following_url ) {
        this.following_url = following_url;
    }
    public String getGists_url () {
        return this.gists_url;
    }
    public void setGists_url ( String gists_url ) {
        this.gists_url = gists_url;
    }
    public String getStarred_url () {
        return this.starred_url;
    }
    public void setStarred_url ( String starred_url ) {
        this.starred_url = starred_url;
    }
    public String getSubscriptions_url () {
        return this.subscriptions_url;
    }
    public void setSubscriptions_url ( String subscriptions_url ) {
        this.subscriptions_url = subscriptions_url;
    }
    public String getOrganizations_url () {
        return this.organizations_url;
    }
    public void setOrganizations_url ( String organizations_url ) {
        this.organizations_url = organizations_url;
    }
    public String getRepos_url () {
        return this.repos_url;
    }
    public void setRepos_url ( String repos_url ) {
        this.repos_url = repos_url;
    }
    public String getEvents_url () {
        return this.events_url;
    }
    public void setEvents_url ( String events_url ) {
        this.events_url = events_url;
    }
    public String getReceived_events_url () {
        return this.received_events_url;
    }
    public void setReceived_events_url ( String received_events_url ) {
        this.received_events_url = received_events_url;
    }
    public String getType () {
        return this.type;
    }
    public void setType ( String type ) {
        this.type = type;
    }
    public boolean getSite_admin () {
        return this.site_admin;
    }
    public void setSite_admin ( boolean site_admin ) {
        this.site_admin = site_admin;
    }
    @Override
    public String toString () {
        return "Owner{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", avatar_url='" + avatar_url + '\'' +
                ", gravatar_id='" + gravatar_id + '\'' +
                ", url='" + url + '\'' +
                ", html_url='" + html_url + '\'' +
                ", followers_url='" + followers_url + '\'' +
                ", following_url='" + following_url + '\'' +
                ", gists_url='" + gists_url + '\'' +
                ", starred_url='" + starred_url + '\'' +
                ", subscriptions_url='" + subscriptions_url + '\'' +
                ", organizations_url='" + organizations_url + '\'' +
                ", repos_url='" + repos_url + '\'' +
                ", events_url='" + events_url + '\'' +
                ", received_events_url='" + received_events_url + '\'' +
                ", type='" + type + '\'' +
                ", site_admin=" + site_admin +
                '}';
    }
}