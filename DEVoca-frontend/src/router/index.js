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
import MainView from '@/views/feed/MainView.vue'
import FeedListView from '@/views/feed/FeedListView.vue'
import OtherUserProfileView from '@/views/DM/OtherUserProfileView.vue'
import DMMessageView from '@/views/DM/DMMessageView.vue'
import CardCreateView from '@/views/card/CardCreateView.vue'
import CardDetailView from '@/views/card/CardDetailView.vue'
import WordListView from '@/views/word/WordListView.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // 전체화면
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
    //DM
    {
      path : '/otherusesrprofile',
      name : 'OtherUserProfileView',
      component : OtherUserProfileView
    },
    {
      path : '/dmmessage',
      name : 'DMMessageView',
      component : DMMessageView
    },
    // 상하단바
    {
      path: '/',
      name: 'MainView',
      component: MainView,
      redirect: '/main',
      children: [
        // feed
        {
          path: '/main',
          name: 'FeedListView',
          component: FeedListView,
        },
        {
          path: '/card/create',
          name: 'CardCreateView',
          component: CardCreateView,
        },
        {
          path: '/card/detail',
          name: 'CardDetailView',
          component: CardDetailView,
        },
        // word
        {
          path: '/word/list',
          name: 'WordListView',
          component: WordListView,
        },
      ]
    },
  ]
})

export default router
