import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '@/views/MembershipManagement/LoginView.vue'
import SignupView from '@/views/MembershipManagement/SignupView.vue'
import SelectInterestsView from '@/views/MembershipManagement/SelectInterestsView.vue'
import MypageView from '@/views/Mypage/MypageView.vue'
import FollowView from '@/views/Mypage/FollowView.vue'
import FollowerView from '@/views/Mypage/FollowerView.vue'
import MainView from '@/views/feeds/MainView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // user
    {
      path: '/login',
      name: 'LoginView',
      component: LoginView
    },
    {
      path:'/signup',
      name:'SignupView',
      component : SignupView
    },
    {
      path: '/selectinterests',
      name: 'SelectInterestsView',
      component : SelectInterestsView
    },
    {
      path : '/mypage',
      name : 'MypageView',
      component : MypageView
    },
    {
      path: '/Follow',
      name : 'FollowView',
      component : FollowView
    },
    {
      path : '/Follower',
      name : 'FollowerView',
      component : FollowerView
    },
    // feed
    {
      path: '/',
      name: 'MainView',
      component: MainView
    },
  ]
})

export default router
