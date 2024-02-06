import daisyui from 'daisyui'
import defaultTheme from 'tailwindcss/defaultTheme'

/** @type {import('tailwindcss').Config} */
export default {
  content: ['./**/*.{html,js}'],
  theme: {
    extend: {
      fontFamily: {
        sans: ['GmarketSansMedium', ...defaultTheme.fontFamily.sans],
        jalnan: ['JalnanGothic']
      },
      colors: {
        devoca: '#00B4D8', // 대표색
        devoca_sky: '#DDF7FC',
        devoca_skyblue: '#ECFCFF' // 연하늘
      }
    }
  },
  plugins: [
    daisyui
  ]
}

