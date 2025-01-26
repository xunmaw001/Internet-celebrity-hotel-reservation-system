const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmui9bt/",
            name: "ssmui9bt",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmui9bt/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "网红酒店预定系统的设计与实现"
        } 
    }
}
export default base
