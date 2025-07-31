/** @type {import('tailwindcss').Config} */
module.exports = {
    content: [
        './src/main/resources/templates/**/*.html', // for Spring Boot Thymeleaf templates
        './src/main/resources/static/**/*.html',    // optional if you have static HTML
        './src/main/resources/static/**/*.js',      // if you're using Tailwind in JS
    ],
    theme: {
        extend: {},
    },
    plugins: [],
}
