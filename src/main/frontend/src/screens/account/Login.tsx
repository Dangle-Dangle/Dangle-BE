import React, { useState } from "react";
import "../../styles/account/Login.css";
import { FcGoogle } from "react-icons/fc";
import { SiKakao, SiNaver } from "react-icons/si";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";

const Login: React.FC = () => {
    const navigation = useNavigate();
    const [id, setId] = useState<string>("");
    const [pw, setPw] = useState<string>("");

    const loginButton = async () => {
        if (!id.trim()) {
            alert("아이디를 입력해주세요.");
        }
        if (!pw.trim()) {
            alert("비밀번호를 입력해주세요.");
            return;
        }

        try {
            const response = await axios.post(
                "/auth/login",
                null,
                {
                    params: {
                        userId: id,
                        userPw: pw
                    },
                    withCredentials: true,
                }
            );

            if (response.status === 200) {
                alert("로그인 성공!");
                navigation("/home");
            } else {
                alert("로그인 실패!")
            }
        } catch (error) {
            console.error("로그인 요청 실패:", error);
            alert("서버 오류가 발생했습니다.")
        }
    };

    return (
        <div className="loginContainer">
            <div>DangleDangle</div>
            <div>로그인</div>
            <div className="login-info">
                <p>아이디</p>
                <input type="text" value={id} onChange={(e) => setId(e.target.value)} />
                <p>비밀번호</p>
                <input type="password" value={pw} onChange={(e) => setPw(e.target.value)} />
            </div>
            <div className="loginButton">
                <button onClick={loginButton}>로그인</button>
            </div>
            <div className="textWrap">
                <Link to="/joinAgree">회원가입</Link>
                <Link to="/searchAccount">아이디/비밀번호 찾기</Link>
            </div>
            <div className="snsContainer">
                <div>
                    <FcGoogle />
                </div>
                <div>
                    <SiKakao />
                </div>
                <div>
                    <SiNaver />
                </div>
            </div>
        </div>
    );
};

export default Login;
