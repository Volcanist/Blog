package com.tc.common;

public class SystemConstants
{
    /**
     *  文章是草稿状态
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;
    /**
     *  文章是发布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;

    /**
     * 分类是删除状态
     */
    public static final String STATUS_DRAFT = "1";
    /**
     * 分类是正常状态
     */
    public static final String STATUS_NORMAL = "0";

    /**
     * 友联审核通过
     */
    public static final String LINK_STATUS_NORMAL = "0";

    /**
     * 友联审核未通过
     */
    public static final String LINK_STATUS_FALSE = "1";

    /**
     * 友联未审核
     */
    public static final String LINK_STATUS_NOTYET = "2";

    /**
     * 评论类型为：文章评论
     */
    public static final String ARTICLE_COMMENT = "0";
    /**
     * 评论类型为：友联评论
     */
    public static final String LINK_COMMENT = "1";

}
