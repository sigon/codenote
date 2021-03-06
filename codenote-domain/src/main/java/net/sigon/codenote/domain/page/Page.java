package net.sigon.codenote.domain.page;

/**
 * Created with IntelliJ IDEA.
 * User: yf-liulei
 * Date: 14-5-1
 * Time: 下午3:48
 * To change this template use File | Settings | File Templates.
 */


import net.sigon.codenote.domain.constant.Constant;

/** 针对当前的mysql做了精简
 * @date 2011-12-1 上午11:36:12
 */
public class Page {
    // 分页查询开始记录位置
    private int begin;
    // 分页查看下结束位置
    private int end;
    // 每页显示记录数
    private int length;
    // 当前页码
    private int current;

    public Page() {
    }

    public Page(int current,int length){
        if(current == 0){
            current = 1;
        }

        if(length == 0){
            length = Constant.PAGE_SIZE;
        }

        begin = (current-1) * length;
        end = length;
    }

    /**
     * @return the begin
     */
    public int getBegin() {
        return begin;
    }

    /**
     * @return the end
     */
    public int getEnd() {
        return end;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "Page{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }
}
