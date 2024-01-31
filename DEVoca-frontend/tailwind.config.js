/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{vue,js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      fontFamily: {
        jalnan: ['JalnanGothic'],
      },
      colors: {
        devoca: '#00B4D8'
      }
    },
  },
  plugins: [require("daisyui")],
}

