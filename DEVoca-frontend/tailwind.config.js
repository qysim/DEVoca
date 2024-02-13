/** @type {import('tailwindcss').Config} */

const defaultTheme = require('tailwindcss/defaultTheme')

export default {
  content: [
    "./index.html",
    "./src/**/*.{vue,js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      fontFamily: {
        sans: ['GmarketSansMedium', ...defaultTheme.fontFamily.sans],
        jalnan: ['JalnanGothic'],
      },
      colors: {
        devoca_skyblue: '#ECFCFF', // 연하늘
        devoca: '#00B4D8', // 대표색
        devoca_sky: '#DDF7FC',
      }
    },
  },
  plugins: [require("daisyui"),
  require("tailwind-scrollbar-hide")],
  daisyui: {
    themes: ["cupcake"]
  }
}

