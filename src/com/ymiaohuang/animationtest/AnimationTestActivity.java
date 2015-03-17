package com.ymiaohuang.animationtest;

/*	Tweened Animations：该类Animations提供了旋转、移动、伸展和淡出等效果。
 * 	Alpha——淡入淡出，Scale——缩放效果，Rotate——旋转，Translate——移动效果。
 *	2.Frame-by-frame Animations：这一类Animations可以创建一个Drawable序列，
 *	这些Drawable可以按照指定的时间间歇一个一个的显示。
 * 
 *  １、setDuration(long durationMills)
 *　设置动画持续时间（单位：毫秒）
 *　２、setFillAfter(Boolean fillAfter)
 *　如果fillAfter的值为true,则动画执行后，控件将停留在执行结束的状态
 *　	３、setFillBefore(Boolean fillBefore)
 *　如果fillBefore的值为true，则动画执行后，控件将回到动画执行之前的状态
 *　４、setStartOffSet(long startOffSet)
 *　设置动画执行之前的等待时间
 *　５、setRepeatCount(int repeatCount)
 *　设置动画重复执行的次数
 * 
 * */
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationTestActivity extends Activity implements OnClickListener {
	private Button rotateButton = null;
	private Button scaleButton = null;
	private Button alphaButton = null;
	private Button translateButton = null;
	private Button cancelButton = null;
	private ImageView image = null;

	private AnimationSet animationSet1;
	private RotateAnimation rotateAnimation;
	private ScaleAnimation scaleAnimation;
	private TranslateAnimation translateAnimation;

	private WindowManager wm;
	private int w, h, c = 0;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initView();

	}

	private void initView() {
		rotateButton = (Button) findViewById(R.id.btn_main_rotate);
		scaleButton = (Button) findViewById(R.id.btn_main_scale);
		alphaButton = (Button) findViewById(R.id.btn_main_alpha);
		translateButton = (Button) findViewById(R.id.btn_main_translate);
		cancelButton = (Button) findViewById(R.id.btn_main_cancel);
		image = (ImageView) findViewById(R.id.image);

		rotateButton.setOnClickListener(this);
		scaleButton.setOnClickListener(this);
		alphaButton.setOnClickListener(this);
		translateButton.setOnClickListener(this);
		cancelButton.setOnClickListener(this);

		wm = (WindowManager) getApplicationContext().getSystemService(
				Context.WINDOW_SERVICE);
		w = wm.getDefaultDisplay().getWidth();
		h = wm.getDefaultDisplay().getHeight();
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_main_alpha:
			// 创建一个AnimationSet对象，参数为Boolean型，
			// true表示使用Animation允许共用同一个set，能实现多效果。
			// 补插器，用来修饰动画效果。例如始末旋转速率慢，中间快。
			animationSet1 = new AnimationSet(true);
			// 创建一个AlphaAnimation对象，参数从完全的透明度，到完全的不透明
			AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
			// 设置动画执行的时间
			alphaAnimation.setDuration(500);
			// 将alphaAnimation对象添加到AnimationSet当中，能添加多个效果。
			animationSet1.addAnimation(alphaAnimation);
			// 使用ImageView的startAnimation方法执行动画
			image.startAnimation(animationSet1);
			break;
		case R.id.btn_main_rotate:
			// 这里就不用interpolator了，如果补插器的效果不是你想要的，也可自定义补插器。
			// 使用XML文件进行补间动画配置。
			// 参数1：从哪个旋转角度开始
			// 参数2：转到什么角度
			// 后4个参数用于设置围绕着旋转的圆的圆心在哪里
			// 参数3：确定x轴坐标的类型，有ABSOLUT绝对坐标、RELATIVE_TO_SELF相对于自身坐标、RELATIVE_TO_PARENT相对于父控件的坐标
			// 参数4：x轴的值，0.5f表明是以自身这个控件的一半长度为x轴
			// 参数5：确定y轴坐标的类型
			// 参数6：y轴的值，0.5f表明是以自身这个控件的一半长度为x轴
			/*
			rotateAnimation = new RotateAnimation(0, 360,
					Animation.RELATIVE_TO_SELF, 0.5f,
					Animation.RELATIVE_TO_SELF, 0.5f);
			rotateAnimation.setDuration(1000);
			rotateAnimation.setRepeatCount(2);// 转3圈，0为一圈。
			image.startAnimation(rotateAnimation);
			*/
			break;
		case R.id.btn_main_scale:
			// 参数1：x轴的初始值
			// 参数2：x轴收缩后的值
			// 参数3：y轴的初始值
			// 参数4：y轴收缩后的值
			// 参数5：确定x轴坐标的类型
			// 参数6：x轴的值，0.5f表明是以自身这个控件的一半长度为x轴
			// 参数7：确定y轴坐标的类型
			// 参数8：y轴的值，0.5f表明是以自身这个控件的一半长度为x轴
			scaleAnimation = new ScaleAnimation(1, 0, 1, 0,
					Animation.RELATIVE_TO_SELF, 0.5f,
					Animation.RELATIVE_TO_SELF, 0.5f);
			scaleAnimation.setDuration(1000);
			scaleAnimation.setFillAfter(true);
			image.startAnimation(scaleAnimation);
			break;
		case R.id.btn_main_translate:
			// 参数1～2：x轴的开始位置
			// 参数3～4：x轴的结束位置
			// 参数5～6：y轴的开始位置
			// 参数7～8：y轴的结束位置
			/*
			 * translateAnimation = new TranslateAnimation(
			 * Animation.RELATIVE_TO_SELF, -1f, Animation.RELATIVE_TO_SELF, 1f,
			 * Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
			 * translateAnimation.setDuration(1000);
			 * image.startAnimation(translateAnimation);
			 */

			if (c % 2 == 0) {
				slideview(0, 200);
				c++;
			} else {
				slideview(0, -200);
				c--;
			}
			break;

		case R.id.btn_main_cancel:
			translateAnimation.cancel();
		}

	}

	public void slideview(final float p1, final float p2) {
		translateAnimation = new TranslateAnimation(p1, p2, 0, 0);
		translateAnimation.setDuration(1000);
		translateAnimation
				.setAnimationListener(new Animation.AnimationListener() {
					public void onAnimationStart(Animation animation) {
					}

					public void onAnimationRepeat(Animation animation) {
					}

					public void onAnimationEnd(Animation animation) {
						int left = image.getLeft() + (int) (p2 - p1);
						int top = image.getTop();
						int width = image.getWidth();
						int height = image.getHeight();
						image.clearAnimation();
						image.layout(left, top, left + width, top + height);
						//左上角定点的坐标，控件的宽高。
					}
				});
		image.startAnimation(translateAnimation);
	}

}