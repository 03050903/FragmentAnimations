package com.labo.kaji.fragmentanimations.example;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import com.labo.kaji.fragmentanimations.CubeAnimation;
import com.labo.kaji.fragmentanimations.FlipAnimation;
import com.labo.kaji.fragmentanimations.MoveAnimation;
import com.labo.kaji.fragmentanimations.PushPullAnimation;
import com.labo.kaji.fragmentanimations.SidesAnimation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author kakajika
 * @since 2015/11/27
 */
public class ExampleFragment extends Fragment {

    @IntDef({NODIR, UP, DOWN, LEFT, RIGHT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AnimationDirection {}
    public static final int NODIR = 0;
    public static final int UP    = 1;
    public static final int DOWN  = 2;
    public static final int LEFT  = 3;
    public static final int RIGHT = 4;

    private interface FragmentAnimation {
        Animation create(@AnimationDirection int direction, boolean enter, long duration);
        String getLabel();
    }

    enum AnimationStyle implements FragmentAnimation {
        MOVE {
            @Override
            public Animation create(@AnimationDirection int direction, boolean enter, long duration) {
                switch (direction) {
                    case UP:
                        return MoveAnimation.create(MoveAnimation.UP, enter, DURATION);
                    case DOWN:
                        return MoveAnimation.create(MoveAnimation.DOWN, enter, DURATION);
                    case LEFT:
                        return MoveAnimation.create(MoveAnimation.LEFT, enter, DURATION);
                    case RIGHT:
                        return MoveAnimation.create(MoveAnimation.RIGHT, enter, DURATION);
                }
                return null;
            }
            @Override
            public String getLabel() {
                return "Move";
            }
        },
        CUBE {
            @Override
            public Animation create(@AnimationDirection int direction, boolean enter, long duration) {
                switch (direction) {
                    case UP:
                        return CubeAnimation.create(CubeAnimation.UP, enter, DURATION);
                    case DOWN:
                        return CubeAnimation.create(CubeAnimation.DOWN, enter, DURATION);
                    case LEFT:
                        return CubeAnimation.create(CubeAnimation.LEFT, enter, DURATION);
                    case RIGHT:
                        return CubeAnimation.create(CubeAnimation.RIGHT, enter, DURATION);
                }
                return null;
            }
            @Override
            public String getLabel() {
                return "Cube";
            }
        },
        FLIP {
            @Override
            public Animation create(@AnimationDirection int direction, boolean enter, long duration) {
                switch (direction) {
                    case UP:
                        return FlipAnimation.create(FlipAnimation.UP, enter, DURATION);
                    case DOWN:
                        return FlipAnimation.create(FlipAnimation.DOWN, enter, DURATION);
                    case LEFT:
                        return FlipAnimation.create(FlipAnimation.LEFT, enter, DURATION);
                    case RIGHT:
                        return FlipAnimation.create(FlipAnimation.RIGHT, enter, DURATION);
                }
                return null;
            }
            @Override
            public String getLabel() {
                return "Flip";
            }
        },
        PUSHPULL {
            @Override
            public Animation create(@AnimationDirection int direction, boolean enter, long duration) {
                switch (direction) {
                    case UP:
                        return PushPullAnimation.create(PushPullAnimation.UP, enter, DURATION);
                    case DOWN:
                        return PushPullAnimation.create(PushPullAnimation.DOWN, enter, DURATION);
                    case LEFT:
                        return PushPullAnimation.create(PushPullAnimation.LEFT, enter, DURATION);
                    case RIGHT:
                        return PushPullAnimation.create(PushPullAnimation.RIGHT, enter, DURATION);
                }
                return null;
            }
            @Override
            public String getLabel() {
                return "Push/Pull";
            }
        },
        SIDES {
            @Override
            public Animation create(@AnimationDirection int direction, boolean enter, long duration) {
                switch (direction) {
                    case UP:
                        return SidesAnimation.create(SidesAnimation.UP, enter, DURATION);
                    case DOWN:
                        return SidesAnimation.create(SidesAnimation.DOWN, enter, DURATION);
                    case LEFT:
                        return SidesAnimation.create(SidesAnimation.LEFT, enter, DURATION);
                    case RIGHT:
                        return SidesAnimation.create(SidesAnimation.RIGHT, enter, DURATION);
                }
                return null;
            }
            @Override
            public String getLabel() {
                return "Sides";
            }
        },
        CUBEMOVE {
            @Override
            public Animation create(@AnimationDirection int direction, boolean enter, long duration) {
                switch (direction) {
                    case UP:
                        return enter ? MoveAnimation.create(MoveAnimation.UP, enter, DURATION).fading(0.3f, 1.0f) :
                                CubeAnimation.create(CubeAnimation.UP, enter, DURATION).fading(1.0f, 0.3f);
                    case DOWN:
                        return enter ? MoveAnimation.create(MoveAnimation.DOWN, enter, DURATION).fading(0.3f, 1.0f) :
                                CubeAnimation.create(CubeAnimation.DOWN, enter, DURATION).fading(1.0f, 0.3f);
                    case LEFT:
                        return enter ? MoveAnimation.create(MoveAnimation.LEFT, enter, DURATION).fading(0.3f, 1.0f) :
                                CubeAnimation.create(CubeAnimation.LEFT, enter, DURATION).fading(1.0f, 0.3f);
                    case RIGHT:
                        return enter ? MoveAnimation.create(MoveAnimation.RIGHT, enter, DURATION).fading(0.3f, 1.0f) :
                                CubeAnimation.create(CubeAnimation.RIGHT, enter, DURATION).fading(1.0f, 0.3f);
                }
                return null;
            }
            @Override
            public String getLabel() {
                return "Cube/Move";
            }
        },
        MOVECUBE {
            @Override
            public Animation create(@AnimationDirection int direction, boolean enter, long duration) {
                switch (direction) {
                    case UP:
                        return enter ? CubeAnimation.create(CubeAnimation.UP, enter, DURATION).fading(0.3f, 1.0f) :
                                MoveAnimation.create(MoveAnimation.UP, enter, DURATION).fading(1.0f, 0.3f);
                    case DOWN:
                        return enter ? CubeAnimation.create(CubeAnimation.DOWN, enter, DURATION).fading(0.3f, 1.0f) :
                                MoveAnimation.create(MoveAnimation.DOWN, enter, DURATION).fading(1.0f, 0.3f);
                    case LEFT:
                        return enter ? CubeAnimation.create(CubeAnimation.LEFT, enter, DURATION).fading(0.3f, 1.0f) :
                                MoveAnimation.create(MoveAnimation.LEFT, enter, DURATION).fading(1.0f, 0.3f);
                    case RIGHT:
                        return enter ? CubeAnimation.create(CubeAnimation.RIGHT, enter, DURATION).fading(0.3f, 1.0f) :
                                MoveAnimation.create(MoveAnimation.RIGHT, enter, DURATION).fading(1.0f, 0.3f);
                }
                return null;
            }
            @Override
            public String getLabel() {
                return "Move/Cube";
            }
        },
        PUSHMOVE {
            @Override
            public Animation create(@AnimationDirection int direction, boolean enter, long duration) {
                switch (direction) {
                    case UP:
                        return enter ? MoveAnimation.create(MoveAnimation.UP, enter, DURATION) :
                                PushPullAnimation.create(PushPullAnimation.UP, enter, DURATION);
                    case DOWN:
                        return enter ? MoveAnimation.create(MoveAnimation.DOWN, enter, DURATION) :
                                PushPullAnimation.create(PushPullAnimation.DOWN, enter, DURATION);
                    case LEFT:
                        return enter ? MoveAnimation.create(MoveAnimation.LEFT, enter, DURATION) :
                                PushPullAnimation.create(PushPullAnimation.LEFT, enter, DURATION);
                    case RIGHT:
                        return enter ? MoveAnimation.create(MoveAnimation.RIGHT, enter, DURATION) :
                                PushPullAnimation.create(PushPullAnimation.RIGHT, enter, DURATION);
                }
                return null;
            }
            @Override
            public String getLabel() {
                return "Push/Move";
            }
        },
        MOVEPULL {
            @Override
            public Animation create(@AnimationDirection int direction, boolean enter, long duration) {
                switch (direction) {
                    case UP:
                        return enter ? PushPullAnimation.create(PushPullAnimation.UP, enter, DURATION) :
                                MoveAnimation.create(MoveAnimation.UP, enter, DURATION).fading(1.0f, 0.3f);
                    case DOWN:
                        return enter ? PushPullAnimation.create(PushPullAnimation.DOWN, enter, DURATION) :
                                MoveAnimation.create(MoveAnimation.DOWN, enter, DURATION).fading(1.0f, 0.3f);
                    case LEFT:
                        return enter ? PushPullAnimation.create(PushPullAnimation.LEFT, enter, DURATION) :
                                MoveAnimation.create(MoveAnimation.LEFT, enter, DURATION).fading(1.0f, 0.3f);
                    case RIGHT:
                        return enter ? PushPullAnimation.create(PushPullAnimation.RIGHT, enter, DURATION) :
                                MoveAnimation.create(MoveAnimation.RIGHT, enter, DURATION).fading(1.0f, 0.3f);
                }
                return null;
            }
            @Override
            public String getLabel() {
                return "Move/Pull";
            }
        };

        AnimationStyle next() {
            AnimationStyle[] styles = values();
            for (int i=0; i<styles.length-1; ++i) {
                if (this == styles[i]) {
                    return styles[i+1];
                }
            }
            return MOVE;
        }
    }

    private static final long DURATION = 500;

    @NonNull
    private static AnimationStyle sAnimationStyle = AnimationStyle.CUBE;

    @Bind(R.id.textAnimationStyle)
    TextView mTextAnimationStyle;

    public static ExampleFragment newInstance(@AnimationDirection int direction) {
        ExampleFragment f = new ExampleFragment();
        f.setArguments(new Bundle());
        f.getArguments().putInt("direction", direction);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_anim, null);
        int color = Color.rgb((int) Math.floor(Math.random() * 64) + 128,
                              (int) Math.floor(Math.random() * 64) + 128,
                              (int) Math.floor(Math.random() * 64) + 128);
        view.setBackgroundColor(color);
        ButterKnife.bind(this, view);
        mTextAnimationStyle.setText(sAnimationStyle.getLabel());
        return view;
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        @AnimationDirection int direction = getArguments().getInt("direction");
        return sAnimationStyle.create(direction, enter, DURATION);
    }

    @OnClick(R.id.buttonUp)
    void onButtonUp() {
        animateTowardsDirection(UP);
    }

    @OnClick(R.id.buttonDown)
    void onButtonDown() {
        animateTowardsDirection(DOWN);
    }

    @OnClick(R.id.buttonLeft)
    void onButtonLeft() {
        animateTowardsDirection(LEFT);
    }

    @OnClick(R.id.buttonRight)
    void onButtonRight() {
        animateTowardsDirection(RIGHT);
    }

    private void animateTowardsDirection(@AnimationDirection int direction) {
        getArguments().putInt("direction", direction);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.layout_main, ExampleFragment.newInstance(direction));
        ft.commit();
    }

    @OnClick(R.id.textAnimationStyle)
    public void switchAnimationStyle(View view) {
        setAnimationStyle(sAnimationStyle.next());
    }

    public void setAnimationStyle(AnimationStyle style) {
        if (sAnimationStyle != style) {
            sAnimationStyle = style;
            mTextAnimationStyle.setText(style.getLabel());
            Snackbar.make(getView(), "Animation Style is Changed", Snackbar.LENGTH_SHORT).show();
        }
    }

}
