/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./pages/*.{html,js,ts,jsx,tsx}'],
  theme: {
    extend: {},
    colors: {
      transparent: 'transparent',
      current: 'currentColor',
      blue: '#058FB2',
      yellow: '#f9ae33',
      cyan: '#47c7eb',
      gray:'#c8d9cd',
      green:'#527e4b',
      bg_gray:'#D9D9D9',
      white:'#FFFFFF',
      black:'#000000',
    },

    fontFamily: {
      Roboto: ['Roboto', 'sans-serif'],
      Raleway: ['Raleway', 'sans-serif'],
    },

  },
  plugins: [],
}

