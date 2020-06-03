import React, { PureComponent } from 'react';
import request from '../../helpers/request'
import { Link } from 'react-router-dom'

export default class Login extends PureComponent {
  constructor(props){
		super(props);
		this.state = {
      username:'',
      password:''
		}
  }
  
  handleUsername(e){
		this.setState({
			userName: e.target.value
		})
  }
  
  handlePassword(e) {
    this.setState({
			password: e.target.value
		})
  }

  login = () => {
    let _this = this
    request({
      url: '/demo-web/user/login',
      method: 'post',
      params: _this.state
    }).then(response => {
      console.info(response);
      localStorage.setItem('user', JSON.stringify(response.data));
      _this.props.history.push('/user')
    })
  }




  render() {
    return (
      <div className="g-login">
        登录
        <br />
        <div>
          用户名：<input type="text" onChange={this.handleUsername.bind(this)}/>
        </div>
        <div>
          密码：<input type="text" onChange={this.handlePassword.bind(this)}/>
        </div>
        <div>
          <button onClick={this.login}>登录</button>
          <Link to={`/register`}>注册</Link>
        </div>
      </div>
    )
  }
}