package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zevent.youness.calculationtools.R;

import java.util.List;

import bean.Departement;


/**
 * Created by youness on 2017-08-09.
 */

public class DepartementDetailAdapter extends BaseAdapter {
    List<Departement> departementList;
    Context context;

    public DepartementDetailAdapter(List<Departement> departementList, Context context) {
        this.departementList = departementList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return departementList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        convertView=layoutInflater.inflate(R.layout.departement_detail_item,null);

        TextView depId= (TextView) convertView.findViewById(R.id.departementId);
        TextView depName= (TextView) convertView.findViewById(R.id.departementName);


        depId.setText(""+departementList.get(position).getId());
        depName.setText(""+departementList.get(position).getName());

        return convertView;
    }
}
