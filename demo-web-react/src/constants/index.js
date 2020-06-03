export const ORIGIN = {
  production: window.location.origin,
  development: `http://localhost:8081`,
  test: window.location.origin,
  // dev: 'http://localhost:3009',
}[process.env.NODE_ENV || 'development'];