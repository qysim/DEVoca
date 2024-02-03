import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '@/views/MembershipManagement/LoginView.vue'
import SignupView from '@/views/MembershipManagement/SignupView.vue'
import SelectInterestsView from '@/views/MembershipManagement/SelectInterestsView.vue'
import MypageView from '@/views/Mypage/MypageView.vue'
import FollowView from '@/views/Mypage/FollowView.vue'
import FollowerView from '@/views/Mypage/FollowerView.vue'
import MypageSettingView from '@/views/Mypage/MypageSettingView.vue'
import SelectInterestsChangeView from '@/views/Mypage/SelectInterestsChangeView.vue'
import PasswordChangeView from '@/views/Mypage/PasswordChangeView.vue'
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
    {
      path : '/mypagesetting',
      name : 'MypageSettingView',
      component : MypageSettingView
    },
    {
      path : '/selecinterestschange',
      name : 'SelectInterestsChangeView',
      component : SelectInterestsChangeView
    },
    {
      path : '/passwordchange',
      name : 'PasswordChangeView',
      component : PasswordChangeView
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
