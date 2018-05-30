package pr.tongson.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pr.tongson.R;

/**
 * <b>Create Date:</b> 2018/5/30<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public class KeyBoardAdapter extends RecyclerView.Adapter<KeyBoardAdapter.MyViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private String[] keyNames;
    private DisplayMetrics dm;
    private int screenWidth;
    private int itemWidth;
    private OnItemClickLitener mOnItemClickLitener;

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    public OnItemClickLitener getOnItemClickLitener() {
        return mOnItemClickLitener;
    }

    public void setOnItemClickLitener(OnItemClickLitener onItemClickLitener) {
        mOnItemClickLitener = onItemClickLitener;
    }


    public KeyBoardAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        keyNames = new String[]{"C", "()", "%", "×", "7", "8", "9", "÷", "4", "5", "6", "－", "1", "2", "3", "＋", "±", "0", ".", "＝"};
        dm = context.getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        itemWidth = screenWidth / 4;
    }

    @NonNull
    @Override
    public KeyBoardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(mInflater.inflate(R.layout.name_item_keyboard, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.keyNameTv.setText(keyNames[position]);
        ViewGroup.LayoutParams lp = holder.keyNameTv.getLayoutParams();
        lp.width = itemWidth;
        lp.height = itemWidth;
        holder.keyNameTv.setLayoutParams(lp);
        setClick(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return keyNames.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView keyNameTv;

        public MyViewHolder(View view) {
            super(view);
            keyNameTv = (TextView) view.findViewById(R.id.tv_key_name);
        }
    }


    private void setClick(final View view, final int layoutPosition) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickLitener.onItemClick(view, layoutPosition);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mOnItemClickLitener.onItemLongClick(view, layoutPosition);
                return false;
            }
        });
    }

}
