package iran.alirezanazari.cleanarchitect.ui.activities;

public abstract class BasePresenter<V> {

    private V view ; //can be weakReference

    public void bindView(V view){
        this.view = view ;
    }

    public void unbindView(){
        this.view = null ;
    }

    public V getView(){
        return view;
    }


}
