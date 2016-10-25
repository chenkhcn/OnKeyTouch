package com.gdmec.s07150706.onkeytouch;

import android.inputmethodservice.Keyboard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
        private TextView tv1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //setContentView(R.layout.activity_main);
            tv1=new TextView(this);
            tv1.setText("请单击按钮或者屏幕");
            setContentView(tv1);
        }

        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_HOME:
                    SetMessage("你按下了HOME键");
                    break;
                case KeyEvent.KEYCODE_MENU:
                    SetMessage("你按下了菜单键");
                    break;
                case KeyEvent.KEYCODE_BACK:
                    SetMessage("你按下了回退键");
                    break;
                case KeyEvent.KEYCODE_VOLUME_UP:
                    SetMessage("你按下了音量加大键");
                    break;
                case KeyEvent.KEYCODE_VOLUME_DOWN:
                    SetMessage("你按下了音量减少键");
                    break;
                default:
                    SetMessage("放开的键码是："+keyCode);
                    break;
            }
            return super.onKeyDown(keyCode, event);
        }

        @Override
        public boolean onKeyUp(int keyCode, KeyEvent event) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_HOME:
                    SetMessage("你放开了HOME键");
                    break;
                case KeyEvent.KEYCODE_MENU:
                    SetMessage("你放开了菜单键");
                    break;
                case KeyEvent.KEYCODE_BACK:
                    SetMessage("你放开了回退键");
                    break;
                case KeyEvent.KEYCODE_VOLUME_UP:
                    SetMessage("你放开了音量加大键");
                    break;
                case KeyEvent.KEYCODE_VOLUME_DOWN:
                    SetMessage("你放开了音量减少键");
                    break;
                default:
                    SetMessage("放开的键码是" + keyCode);
                    break;
            }
            return super.onKeyUp(keyCode, event);
        }

        @Override
        public boolean onKeyLongPress(int keyCode, KeyEvent event) {
            SetMessage("长时间按键");
            return super.onKeyLongPress(keyCode, event);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            int action=event.getAction();

            if(action==MotionEvent.ACTION_CANCEL||action == MotionEvent.ACTION_DOWN||action== MotionEvent.ACTION_MOVE){
                return false;
            }
            String x=String.valueOf(event.getX());
            String y=String.valueOf(event.getY());
            SetMessage("触点坐标：（"+x+","+y+")");
            return super.onTouchEvent(event);
        }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            SetMessage("你按下了返回键");
        }

        private void SetMessage(String str) {
            String oldStr=tv1.getText().toString();
            String newStr=oldStr+"\n"+str;
            tv1.setText(newStr);
        }


    }
