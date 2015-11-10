package com.maneater.foundation.uitl;

public class PageUtil {
    private int pageSize;// 每页多少条
    private long totalSize;// 共多少条
    private int curPage;// 当前页，从1开始
    private final static int showSize = 8;
    private final static int preSize = 5;
    private final static int nextSize = showSize - preSize - 1;

    private String otherParams = "";
    private String urlFormat = "list.jhtml?pageSize={pageSize}&pageNum={pageNum}&{otherParams}";

    public String getUrlFormat() {
        return urlFormat;
    }

    public void setUrlFormat(String urlFormat) {
        this.urlFormat = urlFormat;
    }

    /*	<nav class="">
        <ul class="pagination">
        <li>
        <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
        </a>
        </li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li>
        <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
        </a>
        </li>
        </ul>
        </nav>*/
    private String preTagFormat  = "<li><a href=\"{url}\" aria-label=\"Previous\"><span aria-hidden=\"true\">Previous</span></a></li>";
    private String nextTagFormat = "<li><a href=\"{url}\" aria-label=\"Next\"><span aria-hidden=\"true\">Next</span></a></li>";
    private String numTagFormat  = "<li><a href=\"{url}\">{number}</a></li>";
    private String curTagFormat  = "<li class=\"active\"><a href=\"#\" >{number}</a></li>";
    private String expandTagFormat = "<li class=\"disabled\"><a href=\"#\">......</a></li>";
    private String pageInfoTagFormat = "<li class=\"disabled\"><a href=\"#\">{pageSize}条/页 共{totalSize}条记录</a></li>";
    private String baseTagFormat = "<nav class=\"\"><ul class=\"pagination\">{content}</ul></nav>";
    private String noPageTagFormat = "暂无记录";


    public void setOtherParams(String otherParams) {
        this.otherParams = otherParams;
    }

    public String getHtml() {
        StringBuilder html = new StringBuilder();

        if (totalSize > 0) {
            int totalPage = (int) (Math.ceil(totalSize * 1.0f / pageSize));
            if (totalPage <= showSize) {
                // <=maxshow
                StringBuilder conentHtml = new StringBuilder();
                for (int i = 1; i <= totalPage; i++) {
                    if (i == curPage) {
                        conentHtml.append(formatCurTag(i));
                    } else {
                        conentHtml.append(formatNumTag(i, formatUrl(i)));
                    }
                }
                conentHtml.append(formatPageInfo());
                html.append(formatContent(conentHtml.toString()));
            } else {
                // > maxshow
                StringBuilder conentHtml = new StringBuilder();

                // pre page
                if (curPage > 1) {
                    conentHtml.append(preTagFormat.replace("{url}", formatUrl(curPage - 1)));
                }

                // next page
                if (curPage < totalPage) {
                    conentHtml.append(nextTagFormat.replace("{url}", formatUrl(curPage + 1)));
                }

                int[] pageScope = createPageScoe(curPage, totalPage);
                // first page
                if (pageScope[0] > 3) {
                    conentHtml.append(formatNumTag(1, formatUrl(1)));
                    conentHtml.append(expandTagFormat);
                }
                // inner pages
                for (int i = pageScope[0]; i <= pageScope[1]; i++) {
                    if (i == curPage) {
                        conentHtml.append(formatCurTag(i));
                    } else {
                        conentHtml.append(formatNumTag(i, formatUrl(i)));
                    }
                }
                // last page

                if (pageScope[1] < totalPage - 3) {
                    conentHtml.append(expandTagFormat);
                    conentHtml.append(formatNumTag(totalPage, formatUrl(totalPage)));
                }



                conentHtml.append(formatPageInfo());
                html.append(formatContent(conentHtml.toString()));

            }
        } else {
            html.append(formatContent(noPageTagFormat));
        }
        return html.toString();
    }

    private int[] createPageScoe(int curPage, int totalPage) {
        int[] inter = new int[2];
        if (totalPage > showSize) {
            int preNum = curPage - preSize;
            int nextNum = curPage + nextSize;
            // 前后不越界
            if (preNum > 0 && nextNum <= totalPage) {
                inter[0] = preNum;
                inter[1] = nextNum;
            } else {

                // 前越界
                if (preNum <= 0 && nextNum <= totalPage) {
                    inter[0] = 1;
                    inter[1] = showSize;
                }

                // 后越界
                if (preNum > 0 && nextNum > totalPage) {
                    inter[0] = totalPage - showSize + 1;
                    inter[1] = totalPage;
                }
            }
        } else {
            inter[0] = 1;
            inter[1] = totalPage;
        }
        return inter;
    }

    private String formatContent(String conentHtml) {
        return baseTagFormat.replace("{content}", conentHtml.toString());
    }

    private String formatCurTag(int i) {
        return curTagFormat.replace("{number}", String.valueOf(i));
    }

    private String formatNumTag(int i, String url) {
        return numTagFormat.replace("{number}", String.valueOf(i)).replace("{url}", url);
    }

    private String formatUrl(int pageNum) {
        String url = urlFormat.replace("{pageSize}", String.valueOf(pageSize))
                .replace("{pageNum}", String.valueOf(pageNum))
                .replace("{otherParams}", String.valueOf(otherParams));
        return url;
    }

    private String formatPageInfo() {
        return pageInfoTagFormat.replace("{pageSize}", String.valueOf(pageSize)).replace(
                "{totalSize}", String.valueOf(totalSize));
    }

    public static void main(String[] args) {
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageSize(30);
        pageUtil.setCurPage(10);
        pageUtil.setTotalSize(1024);
        System.out.println(pageUtil.getHtml());
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

}
