package bean;

public class Page {

    //总条数
    private int totalNumber;

    //每页显示显示条数
    private int numberInPage = 10;

    //当前页(从1开始算起)
    private int currentPage;

    /**
     * 有以上3个属性就可以计算下面的属性值
     */
    //总页数
    private int totalPage;

    //数据库limit关键字的参数
    private int dbIndex;
    private int dbNumber;

    /**
     * 根据对象已有属性计算其他相关属性
     */
    public void count() {
        totalPage = totalNumber / numberInPage;
        //如果不能整除，则总页数加多一页
        if (totalNumber % numberInPage != 0) {
            totalPage++;
        }
        //保证总页数大于等于1
        if (totalPage <= 0) {
            totalPage = 1;
        }
        //保证当前页数小于等于总页数
        if (totalPage < currentPage) {
            currentPage = totalPage;
        }
        //保证当前页数大于等于1
        if (currentPage < 1) {
            currentPage = 1;
        }

        dbIndex = (currentPage - 1) * numberInPage;
        dbNumber = numberInPage;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getNumberInPage() {
        return numberInPage;
    }

    public void setNumberInPage(int numberInPage) {
        this.numberInPage = numberInPage;
    }

    public int getDbIndex() {
        return dbIndex;
    }

    public void setDbIndex(int dbIndex) {
        this.dbIndex = dbIndex;
    }

    public int getDbNumber() {
        return dbNumber;
    }

    public void setDbNumber(int dbNumber) {
        this.dbNumber = dbNumber;
    }
}
