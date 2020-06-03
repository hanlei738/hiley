import React, { PureComponent } from 'react';
import request from '../../helpers/request'

export default class Login extends PureComponent {
    constructor(props) {
        super(props);
        this.state = {
        }
    }

    handleUsername(e) {
        this.setState({
            userName: e.target.value
        })
    }

    handlePassword(e) {
        this.setState({
            password: e.target.value
        })
    }

    handleEmail(e) {
        this.setState({
            email: e.target.value
        })
    }

    handleCellphone(e) {
        this.setState({
            cellphone: e.target.value
        })
    }

    register = () => {
        let _this = this
        request({
            url: '/demo-web/user/register',
            method: 'post',
            params: _this.state
        }).then(response => {
            if (1 === response.resultCode) {
                alert(response.resultDesc)
                _this.props.history.push('/login')
            } else {
                alert("出错了！")
            }
        })
    }

    render() {
        return (
            <div>
                注册
                <br />
                <div>
                    用户名：<input type="text" onChange={this.handleUsername.bind(this)} />
                </div>
                <div>
                    邮箱：<input type="text" onChange={this.handleEmail.bind(this)} />
                </div>
                <div>
                    密码：<input type="text" onChange={this.handlePassword.bind(this)} />
                </div>
                <div>
                    手机号码：<input type="text" onChange={this.handleCellphone.bind(this)} />
                </div>
                <div>
                    <button onClick={this.register}>提交</button>
                </div>
            </div>
        )
    }
}