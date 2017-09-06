package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zevent.youness.calculationtools.R;

import java.util.List;

import bean.DemandCategory;

/**
 * Created by youness on 2017-08-12.
 */

public class DemandCategoryAdapter extends BaseAdapter {
    List<DemandCategory> demandCategories;
    Context context;

    public DemandCategoryAdapter(List<DemandCategory> demandCategories, Context context) {
        this.demandCategories = demandCategories;
        this.context = context;
    }

    @Override
    public int getCount() {
        return demandCategories.size();
    }

    @Override
    public Object getItem(int position) {
        return demandCategories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        convertView=layoutInflater.inflate(R.layout.demand_category_item,null);

        TextView demandCategoryId= (TextView) convertView.findViewById(R.id.demandCategoryId);
        TextView demandCategoryDepName= (TextView) convertView.findViewById(R.id.demandCategoryDepName);
        TextView demandCategorydate= (TextView) convertView.findViewById(R.id.dateDemandCategory);


        demandCategoryId.setText(""+demandCategories.get(position).getId());
        demandCategoryDepName.setText(""+demandCategories.get(position).getDepartment().getName());
        demandCategorydate.setText(""+demandCategories.get(position).getDateDemandCategory());

        return convertView;
    }
}
