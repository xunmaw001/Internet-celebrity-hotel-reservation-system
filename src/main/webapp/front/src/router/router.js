import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import kehuList from '../pages/kehu/list'
import kehuDetail from '../pages/kehu/detail'
import kehuAdd from '../pages/kehu/add'
import kefangleixingList from '../pages/kefangleixing/list'
import kefangleixingDetail from '../pages/kefangleixing/detail'
import kefangleixingAdd from '../pages/kefangleixing/add'
import kefangxinxiList from '../pages/kefangxinxi/list'
import kefangxinxiDetail from '../pages/kefangxinxi/detail'
import kefangxinxiAdd from '../pages/kefangxinxi/add'
import kefangyudingList from '../pages/kefangyuding/list'
import kefangyudingDetail from '../pages/kefangyuding/detail'
import kefangyudingAdd from '../pages/kefangyuding/add'
import kefangtuidingList from '../pages/kefangtuiding/list'
import kefangtuidingDetail from '../pages/kefangtuiding/detail'
import kefangtuidingAdd from '../pages/kefangtuiding/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'kehu',
					component: kehuList
				},
				{
					path: 'kehuDetail',
					component: kehuDetail
				},
				{
					path: 'kehuAdd',
					component: kehuAdd
				},
				{
					path: 'kefangleixing',
					component: kefangleixingList
				},
				{
					path: 'kefangleixingDetail',
					component: kefangleixingDetail
				},
				{
					path: 'kefangleixingAdd',
					component: kefangleixingAdd
				},
				{
					path: 'kefangxinxi',
					component: kefangxinxiList
				},
				{
					path: 'kefangxinxiDetail',
					component: kefangxinxiDetail
				},
				{
					path: 'kefangxinxiAdd',
					component: kefangxinxiAdd
				},
				{
					path: 'kefangyuding',
					component: kefangyudingList
				},
				{
					path: 'kefangyudingDetail',
					component: kefangyudingDetail
				},
				{
					path: 'kefangyudingAdd',
					component: kefangyudingAdd
				},
				{
					path: 'kefangtuiding',
					component: kefangtuidingList
				},
				{
					path: 'kefangtuidingDetail',
					component: kefangtuidingDetail
				},
				{
					path: 'kefangtuidingAdd',
					component: kefangtuidingAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
