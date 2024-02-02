<template>
  <div class="container h-screen flex items-center">
    <div class="card shrink-0 w-full max-w-sm bg-base-100 mx-auto">
      <div class="flex justify-center">
        <img src="@/assets/images/DEVoca_logo_en_only.png" class="w-3/4">
      </div>
      <form class="card-body">
        <div class="mt-3 flex flex-col items-ceznter">
          <div id="app" class="mb-5">
            <a :href="kakaoLoginLink" alt="kakao login">
              <img alt="kakao logo" src="@/assets/images/kakao_login.png" class="logo" />
            </a>
          </div>

          <div id="app" class="mb-5">
            <a :href="doGoogleLogin" alt="kakao login">
              <img alt="google logo" src="@/assets/images/google_logo.png" class="logo" />
            </a>
          </div>

          <div id="app">
            <a :href="kakaoLoginLink" alt="kakao login">
              <img alt="github logo" src="@/assets/images/github_logo.png" class="logo" />
            </a>
          </div>
        </div>

      </form>
    </div>
  </div>
    <div class="container h-screen flex items-center">
        <div class="card shrink-0 w-full max-w-sm bg-base-100 mx-auto">
            <div class="flex justify-center">
                <img src="@/assets/images/logo.png" class="w-3/4">
            </div>
            <form class="card-body">
                <div class="mt-3 flex flex-col items-ceznter">
                    <div id="app" class="mb-5">
                        <a :href="kakaoLoginLink" alt="kakao login">
                            <img alt="kakao logo" src="@/assets/images/kakao_login.png" class="logo" />
                        </a>
                    </div>
                    <div id="app" class="mb-5">
                        <a :href="doGoogleLogin" alt="kakao login">
                            <img alt="google logo" src="@/assets/images/google_logo.png" class="logo" />
                        </a>
                    </div>
                    <!-- <div id="app">
                        <a :href="kakaoLoginLink" alt="kakao login">
                            <img alt="github logo" src="@/assets/images/github_logo.png" class="logo" />
                        </a>
                    </div> -->
                </div>

            </form>
        </div>
    </div>
</template>
  
<script>
export default {
    name: "App",
    data: () => ({
        client_id: "CLIENT_ID",
        redirect_uri: "http://localhost/oauth/callback",
    }),
    computed: {
        kakaoLoginLink() {
            return `https://kauth.kakao.com/oauth/authorize?client_id=${this.client_id}&redirect_uri=${this.redirect_uri}&response_type=code`;
        },
    },
    doGoogleLogin() {
        const url = 'https://accounts.google.com/o/oauth2/v2/auth?client_id=' +
            process.env.VUE_APP_GOOGLE_CLIENT_ID +
            '&redirect_uri=' +
            process.env.VUE_APP_GOOGLE_REDIRECT_URL +
            '&response_type=code' +
            '&scope=email profile';

        this.showSocialLoginPopup(url)
    },
  }
  // todo
  // doGoogleLogin() {
  //   const url = 'https://accounts.google.com/o/oauth2/v2/auth?client_id=' +
  //       process.env.VUE_APP_GOOGLE_CLIENT_ID +
  //       '&redirect_uri=' +
  //       process.env.VUE_APP_GOOGLE_REDIRECT_URL +
  //       '&response_type=code' +
  //       '&scope=email profile';

  //   this.showSocialLoginPopup(url)
  // },
// };

</script>

<style scoped>
.logo {
  width: 300px;
  height: 50px;
};
</style>