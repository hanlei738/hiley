import React, { PureComponent } from 'react';
import { Link } from 'react-router-dom'
import request from '../../helpers/request'

export default
  class User extends PureComponent {
  state = {
    userLoginLogs: []
  }

  componentDidMount() {
    let user = JSON.parse(localStorage.getItem('user'));
    this.setState({
      user: user
    })

    this.listLoginLog();
  }

  listLoginLog = () => {
    let _this = this
    request({
      url: '/demo-web/userLoginLog/list',
      method: 'post'
    }).then(response => {
      let userLoginLogs = response.data
      _this.setState({
        userLoginLogs: userLoginLogs
      })
    })
  }

  render() {

    let user = this.state.user
    let msg = ''
    if (user) {
      msg = (
        <h2>你好，{user.userName}, 欢迎登录</h2>
      )
    } else {
      msg = (
        <h2>你好，你还没有登录，请<Link to={`/login`}>返回登录</Link></h2>
      )
    }


    return (
      <div>
        <div>{msg}</div>
        <br />
        <div>
          <button onClick={this.listLoginLog}>点击查询所有登录记录</button>
        </div>
        <table>
          <thead>
            <tr>
              <th>登录人姓名</th>
              <th>登录时间</th>
              <th>登录ip</th>
            </tr>
          </thead>
          <tbody>
            {
              this.state.userLoginLogs.map((item, index) => {
                return (
                  <tr>
                    <td>{item.userName}</td>
                    <td>{item.loginTime}</td>
                    <td>{item.loginIp}</td>
                  </tr>
                )
              })

            }

          </tbody>

        </table>
      </div >
    )
  }
}