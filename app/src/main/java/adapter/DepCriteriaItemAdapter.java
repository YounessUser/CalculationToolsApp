package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zevent.youness.calculationtools.R;

import java.util.List;

import bean.DepartementCriteriaItem;

/**
 * Created by youness on 2017-08-20.
 */

public class DepCriteriaItemAdapter extends BaseAdapter {

    List<DepartementCriteriaItem> departementCriteriaItemList;
    Context context;

    public DepCriteriaItemAdapter(List<DepartementCriteriaItem> departementCriteriaItemList, Context context) {
        this.departementCriteriaItemList = departementCriteriaItemList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return departementCriteriaItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return departementCriteriaItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        convertView=layoutInflater.inflate(R.layout.dep_criteria_item_list,null);

        TextView depId= (TextView) convertView.findViewById(R.id.depCriteriaItemDesc);

        depId.setText(departementCriteriaItemList.get(position).getDescription());

        return convertView;
    }
}
