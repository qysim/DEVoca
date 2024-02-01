import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '@/views/LoginView.vue'
import SignupView from '@/views/SignupView.vue'
import SelectInterestsView from '@/views/SelectInterestsView.vue'
import FollowRecommendView from '@/views/FollowRecommendView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // {
    //   path: '/',
    //   name: 'home',
    //   component: HomeView
    // },
    // {
    //   path: '/about',
    //   name: 'about',
    //   component: () => import('../views/AboutView.vue')
    // }
    {
      path : '/login',
      name : 'LoginView',
      component : LoginView
    },
    {
      path:'/signup',
      name:'SigupView',
      component : SignupView
    },
    {
      path: '/selectinterests',
      name: 'SelectInterestsView',
      component : SelectInterestsView
    },
    {
      path:'/followrecommend',
      name: 'FollowRecommendView',
      component : FollowRecommendView
    },
  ]
})

export default router
