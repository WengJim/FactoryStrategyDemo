# FactoryStrategyDemo
工厂策略模式demo
用于APP版本包兼容，比如初始化版本是8.0.0，APP迭代升级到对应的版本，只要方法没升级，那么就允许直接查看最初的方法，若版本有迭代，相应的版本也跟随着升级迭代。
127.0.0.1:8080/strategy?key=8.0.5
8.0.4

127.0.0.1:8080/strategy?key=8.0.1
8.0.0

