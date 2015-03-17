package com.ymiaohuang.animationtest;

/*	Tweened Animations������Animations�ṩ����ת���ƶ�����չ�͵�����Ч����
 * 	Alpha�������뵭����Scale��������Ч����Rotate������ת��Translate�����ƶ�Ч����
 *	2.Frame-by-frame Animations����һ��Animations���Դ���һ��Drawable���У�
 *	��ЩDrawable���԰���ָ����ʱ���Ъһ��һ������ʾ��
 * 
 *  ����setDuration(long durationMills)
 *�����ö�������ʱ�䣨��λ�����룩
 *������setFillAfter(Boolean fillAfter)
 *�����fillAfter��ֵΪtrue,�򶯻�ִ�к󣬿ؼ���ͣ����ִ�н�����״̬
 *��	����setFillBefore(Boolean fillBefore)
 *�����fillBefore��ֵΪtrue���򶯻�ִ�к󣬿ؼ����ص�����ִ��֮ǰ��״̬
 *������setStartOffSet(long startOffSet)
 *�����ö���ִ��֮ǰ�ĵȴ�ʱ��
 *������setRepeatCount(int repeatCount)
 *�����ö����ظ�ִ�еĴ���
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
			// ����һ��AnimationSet���󣬲���ΪBoolean�ͣ�
			// true��ʾʹ��Animation������ͬһ��set����ʵ�ֶ�Ч����
			// ���������������ζ���Ч��������ʼĩ��ת���������м�졣
			animationSet1 = new AnimationSet(true);
			// ����һ��AlphaAnimation���󣬲�������ȫ��͸���ȣ�����ȫ�Ĳ�͸��
			AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
			// ���ö���ִ�е�ʱ��
			alphaAnimation.setDuration(500);
			// ��alphaAnimation������ӵ�AnimationSet���У�����Ӷ��Ч����
			animationSet1.addAnimation(alphaAnimation);
			// ʹ��ImageView��startAnimation����ִ�ж���
			image.startAnimation(animationSet1);
			break;
		case R.id.btn_main_rotate:
			// ����Ͳ���interpolator�ˣ������������Ч����������Ҫ�ģ�Ҳ���Զ��岹������
			// ʹ��XML�ļ����в��䶯�����á�
			// ����1�����ĸ���ת�Ƕȿ�ʼ
			// ����2��ת��ʲô�Ƕ�
			// ��4��������������Χ������ת��Բ��Բ��������
			// ����3��ȷ��x����������ͣ���ABSOLUT�������ꡢRELATIVE_TO_SELF������������ꡢRELATIVE_TO_PARENT����ڸ��ؼ�������
			// ����4��x���ֵ��0.5f����������������ؼ���һ�볤��Ϊx��
			// ����5��ȷ��y�����������
			// ����6��y���ֵ��0.5f����������������ؼ���һ�볤��Ϊx��
			/*
			rotateAnimation = new RotateAnimation(0, 360,
					Animation.RELATIVE_TO_SELF, 0.5f,
					Animation.RELATIVE_TO_SELF, 0.5f);
			rotateAnimation.setDuration(1000);
			rotateAnimation.setRepeatCount(2);// ת3Ȧ��0ΪһȦ��
			image.startAnimation(rotateAnimation);
			*/
			break;
		case R.id.btn_main_scale:
			// ����1��x��ĳ�ʼֵ
			// ����2��x���������ֵ
			// ����3��y��ĳ�ʼֵ
			// ����4��y���������ֵ
			// ����5��ȷ��x�����������
			// ����6��x���ֵ��0.5f����������������ؼ���һ�볤��Ϊx��
			// ����7��ȷ��y�����������
			// ����8��y���ֵ��0.5f����������������ؼ���һ�볤��Ϊx��
			scaleAnimation = new ScaleAnimation(1, 0, 1, 0,
					Animation.RELATIVE_TO_SELF, 0.5f,
					Animation.RELATIVE_TO_SELF, 0.5f);
			scaleAnimation.setDuration(1000);
			scaleAnimation.setFillAfter(true);
			image.startAnimation(scaleAnimation);
			break;
		case R.id.btn_main_translate:
			// ����1��2��x��Ŀ�ʼλ��
			// ����3��4��x��Ľ���λ��
			// ����5��6��y��Ŀ�ʼλ��
			// ����7��8��y��Ľ���λ��
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
						//���ϽǶ�������꣬�ؼ��Ŀ�ߡ�
					}
				});
		image.startAnimation(translateAnimation);
	}

}