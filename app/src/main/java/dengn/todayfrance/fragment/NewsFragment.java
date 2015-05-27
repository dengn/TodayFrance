package dengn.todayfrance.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dengn.todayfrance.R;


public class NewsFragment extends Fragment {
	String text;
	@Override
	public void onCreate(Bundle savedInstanceState) {

		Bundle args = getArguments();
		text = args != null ? args.getString("title") : "";
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_news, null);
		TextView item_textview = (TextView)view.findViewById(R.id.item_textview);
		item_textview.setText(text);
		return view;
	}

}
